package kr.or.ddit.utiles;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.net.URISyntaxException;
import java.net.URL;

import org.apache.commons.io.FileUtils;
import org.slf4j.LoggerFactory;

import ch.qos.logback.classic.LoggerContext;
import ch.qos.logback.classic.joran.JoranConfigurator;
import ch.qos.logback.core.joran.spi.JoranException;

public class LogbackInitialize {

	private final static URL logbackURL = LogbackInitialize.class.getResource("/kr/or/ddit/logback/config/logback.xml");
	
	public static LoggerContext init(){
		 LoggerContext loggerContext = (LoggerContext) LoggerFactory.getILoggerFactory();
		 JoranConfigurator configurator = new JoranConfigurator();
		 
		 configurator.setContext(loggerContext);
         loggerContext.reset();
        
         InputStream configStream;
         
         
         try {
            configStream = FileUtils.openInputStream(new File(logbackURL.toURI()));
            configurator.doConfigure(configStream);
            configStream.close();
         } catch (IOException e) {
            e.printStackTrace();
         } catch (URISyntaxException e) {
            e.printStackTrace();
         } catch (JoranException e) {
            e.printStackTrace();
         }

         return loggerContext;
      }
	 
}
