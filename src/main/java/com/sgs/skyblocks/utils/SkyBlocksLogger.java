package com.sgs.skyblocks.utils;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.Logger;

public class SkyBlocksLogger {
	private static SkyBlocksLogger instance;
	private Logger logger;
	public SkyBlocksLogger(Logger logger) {
		instance = this;
		this.logger = logger;
		
	}
   	public void logInfo(String message) {
   		if(logger != null)
   			logger.info(message);
   	}
    
   	public void logWarning(String message) {
   		if(logger != null)
   			logger.warn(message);
   	}
    
   	public void logSevere(String message) {
   		if(logger != null)
   			logger.error(message);
   	}
   	
   	public void log(Level level, String msg){
   		if(logger != null)
   			logger.log(level, msg);
   	}
   	
   	public void entering(String function, String currentClass){
   		logInfo("Now entering " + function + " in " + currentClass);
   	}
   	
   	public void exiting(String function, String currentClass){
   		logInfo("Now entering " + function + " in " + currentClass);
   	}
   	public static SkyBlocksLogger getLogger(){
   		return instance;
   	}
}
