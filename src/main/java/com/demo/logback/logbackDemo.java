package com.demo.logback;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class logbackDemo {

	private static final Logger logger = LoggerFactory.getLogger(logbackDemo.class);

	public static void main(String[] args) {
		logger.debug("logback bebug msg");
		logger.info("logback info msg");
		logger.warn("logback warn msg");
		logger.error("logback error msg");

	}

}
