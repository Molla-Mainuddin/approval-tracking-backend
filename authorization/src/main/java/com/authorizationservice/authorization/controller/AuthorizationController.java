package com.authorizationservice.authorization.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import com.authorizationservice.authorization.dto.AuthenticationRequestDTO;
import com.authorizationservice.authorization.dto.VaildatingDTO;
import com.authorizationservice.authorization.exceptions.LoginException;
import com.authorizationservice.authorization.model.AuthenticationRequest;
import com.authorizationservice.authorization.model.AuthenticationResponse;
import com.authorizationservice.authorization.service.AppUserDetailsService;
import com.authorizationservice.authorization.util.JwtUtil;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;

@RestController
@Api(value = "Login and Validation endpoints for Authorization Service")
@CrossOrigin("*")
public class AuthorizationController {

	@Autowired
	private AppUserDetailsService userDetailsService;
	@Autowired
	private JwtUtil jwtTokenUtil;

	private static final Logger logger = LoggerFactory.getLogger(AuthorizationController.class);
	private VaildatingDTO vaildatingDTO = new VaildatingDTO();

	@PostMapping("/login")
	@ApiOperation(value = "customerLogin", notes = "takes customer credentials and generates the unique JWT for each customer", httpMethod = "POST", response = ResponseEntity.class)
	public ResponseEntity<Object> createAuthorizationToken(
			@ApiParam(name = "customerLoginCredentials", value = "Login credentials of the Customer") @RequestBody AuthenticationRequestDTO authenticationRequestDTO)
			throws LoginException {

		AuthenticationRequest authenticationRequest = new AuthenticationRequest();
		authenticationRequest.setMid(authenticationRequestDTO.getMemberId());
		authenticationRequest.setUsername(authenticationRequestDTO.getUsername());
		authenticationRequest.setPassword(authenticationRequestDTO.getPassword());
		
		logger.info("BEGIN - [login(customerLoginCredentials)]");
		final UserDetails userDetails = userDetailsService.loadUserByUsername(authenticationRequest.getMid());
		logger.debug("{}", userDetails);
		AuthenticationRequest r = userDetailsService.getUser(authenticationRequest.getMid());
		String memberId = r.getMid();
		String role = r.getRole();
		String userName = r.getUsername();
		if (userDetails.getPassword().equals(authenticationRequest.getPassword())) {
			logger.info("END - [login(customerLoginCredentials)]");
			return new ResponseEntity<>(new AuthenticationResponse(memberId,userName,role,
					jwtTokenUtil.generateToken(userDetails), jwtTokenUtil.getCurrentTime(),
					jwtTokenUtil.getExpirationTime()), HttpStatus.OK);
		}

		logger.info("END - [login(customerLoginCredentials)]");
		throw new LoginException("Invalid Username or Password");
	}

	@GetMapping(path = "/validate", produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value = "tokenValidation", notes = "returns boolean after validating JWT", httpMethod = "GET", response = ResponseEntity.class)
	public ResponseEntity<VaildatingDTO> validatingAuthorizationToken(
			@ApiParam(name = "Authorization", value = "JWT generated for current customer present") @RequestHeader(name = "Authorization") String tokenDup) {
		logger.info("Request is here");
		logger.info("BEGIN - [validatingAuthorizationToken(JWT-token)]");
		String token = tokenDup.substring(7);
		try {
			UserDetails user = userDetailsService.loadUserByUsername(jwtTokenUtil.extractUsername(token));
			if (Boolean.TRUE.equals(jwtTokenUtil.validateToken(token, user))) {
				logger.debug("Token matched is Valid");
				logger.info("Token matched is Valid");
				logger.info("END - validate()");
				vaildatingDTO.setValidStatus(true);
				return new ResponseEntity<>(vaildatingDTO, HttpStatus.OK);
			} else {
				throw new LoginException("Invalid Token");
			}
		} catch (Exception e) {
			logger.debug("Invalid token - Bad Credentials Exception");
			logger.info("END Exception - validatingAuthorizationToken()");
			vaildatingDTO.setValidStatus(false);
			return new ResponseEntity<>(vaildatingDTO, HttpStatus.BAD_REQUEST);
		}

	}

	@GetMapping(path = "/health-check")
	public ResponseEntity<String> healthCheck() {

		logger.info("Authorization Microservice is Up and Running....");
		return new ResponseEntity<>("OK", HttpStatus.OK);
	}

}
