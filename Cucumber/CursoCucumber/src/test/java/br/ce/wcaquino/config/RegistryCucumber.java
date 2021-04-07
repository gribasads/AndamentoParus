package br.ce.wcaquino.config;

import java.util.Locale;

import io.cucumber.core.api.TypeRegistry;
import io.cucumber.core.api.TypeRegistryConfigurer;
import io.cucumber.cucumberexpressions.ParameterType;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class RegistryCucumber implements TypeRegistryConfigurer {

	@Override
	public Locale locale() {
		return Locale.ENGLISH;
	}

	@Override
	public void configureTypeRegistry(TypeRegistry registry) {
		registry.defineParameterType(new ParameterType<>("data", ".*", Date.class, (String s) -> {

			DateFormat format = new SimpleDateFormat("dd/MM/yyyy");
			try {
				Date retorno = format.parse(s);
				return retorno;
			} catch (Exception e) {
				e.printStackTrace();
			}
			return null;
		})

		);

	}

}
