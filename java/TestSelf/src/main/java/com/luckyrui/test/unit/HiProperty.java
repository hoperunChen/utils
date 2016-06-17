package com.luckyrui.test.unit;

import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * 
 * @author Xue Chen
 * 
 */
public class HiProperty extends Properties {

	private static final Logger log = LoggerFactory.getLogger(HiProperty.class);

	/**
	 * 加载属性文件
	 * 
	 * @param propertiesFile
	 * @author Xue Chen Time ：2015年7月16日 下午2:23:00
	 */
	private void load(String propertiesFile) {
		load(propertiesFile, false);
	}

	private void load(String propertiesFile, boolean needPrintExceptionIfNotExist) {
		InputStream in = null;
		try {
			in = HiProperty.class.getResourceAsStream(propertiesFile);
			this.load(in);
		} catch (Exception e) {
			log.warn("-------------Can not find the property file " + propertiesFile
					+ ", but it will not affect to anything for current application. ");
			if (needPrintExceptionIfNotExist) {
				e.printStackTrace();
			}
		} finally {
			Closer.close(in);
		}
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = -4382571842625283586L;

	public HiProperty(String propertiesFile) {
		load(propertiesFile, false);
	}

	public HiProperty(String propertiesFile, boolean needPrintExceptionIfNotExist) {
		load(propertiesFile, needPrintExceptionIfNotExist);
	}

	public void setProperties(List<String> files) {
		for (String file : files) {
			load(file);
		}
	}

	/**
	 * 
	 * @param property
	 * @param defBool
	 * @return
	 * @author Xue Chen Time ：2015年7月16日 下午2:18:59
	 */
	public boolean isEnable(String property, boolean defBool) {
		String str = this.getProperty(property);
		if (str == null) {
			return defBool;
		}
		return "true".equalsIgnoreCase(str.trim()) || "1".equals(str.trim());
	}

	/**
	 * 
	 * @param property
	 * @param defInt
	 * @return
	 * @author Xue Chen Time ：2015年7月16日 下午2:20:36
	 */
	public Integer getInt(String property, Integer defInt) {
		String str = this.getProperty(property);
		if (str == null) {
			return defInt;
		}
		return Integer.valueOf(str.trim());
	}

}
