package com.luckyrui.test.unit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * 流对象关闭工具类
 * 
 * @author Xue Chen
 * 
 */
public class Closer {
	private static final Logger logger = LoggerFactory.getLogger(Closer.class);

	static public void close(InputStream in) {
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				logger.error("error:",e);
			}
	}

	static public void close(OutputStream out) {
		if (out != null)
			try {
				out.close();
			} catch (IOException e) {
				logger.error("error:",e);
			}
	}

	static public void close(Reader in) {
		if (in != null)
			try {
				in.close();
			} catch (IOException e) {
				logger.error("error:",e);
			}
	}

	static public void close(Writer out) {
		if (out != null)
			try {
				out.close();
			} catch (IOException e) {
				logger.error("error:",e);
			}
	}

	static public void close(Connection con) {
		try {
			con.close();
		} catch (Exception e) {
			logger.error("error:",e);
		}
	}

	static public void close(Statement statm) {
		try {
			statm.close();
		} catch (Exception e) {
			logger.error("error:",e);
		}
	}

	static public void close(ResultSet rs) {
		try {
			rs.close();
		} catch (Exception e) {
			logger.error("error:",e);
		}
	}

}
