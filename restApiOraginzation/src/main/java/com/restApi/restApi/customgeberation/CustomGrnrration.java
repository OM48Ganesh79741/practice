

package com.restApi.restApi.customgeberation;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.Driver;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.hibernate.Session;
import org.hibernate.engine.spi.SharedSessionContractImplementor;
import org.hibernate.id.IdentifierGenerator;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CustomGrnrration implements IdentifierGenerator {

	@Override
	public Object generate(SharedSessionContractImplementor session, Object object) {

		String PREFIX = "IBM";
		try {
			Connection connection = session.getJdbcConnectionAccess().obtainConnection();
			java.sql.Statement statement = connection.createStatement();
			ResultSet rs = statement.executeQuery("select nextval('Allperson_seq')");

			System.out.println("*******: "+rs);
			if (rs.next()) {
				long suffix = rs.getLong(1);
						System.out.println("***********+**^^^ "+suffix);
				return PREFIX + suffix;
			}
		} catch (SQLException E) {
			System.out.println("print");
		}
		return null;
	}

}
