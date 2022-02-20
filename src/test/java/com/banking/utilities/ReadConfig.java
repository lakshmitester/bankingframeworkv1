package com.banking.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadConfig {
	Properties pro;
	public ReadConfig() {
		    File src=new File("./Configuration\\config.properties");
			try {
			FileInputStream input=new FileInputStream(src);
			pro=new Properties();
			pro.load(input);
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	public String getApplicationUrl() {
		return pro.getProperty("baseURL");
	}
	public String getUserName() {
		return pro.getProperty("username");
	}
	public String getPassword() {
		return pro.getProperty("password");
	}
	public String getChromePath() {
		return pro.getProperty("chromedriver");
	}
	public String getEdgePath() {
		return pro.getProperty("edgedriver");
	}
}
