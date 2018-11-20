package br.com.felipejunges.simplemath.services;

import br.com.felipejunges.simplemath.repositories.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.text.ParseException;

@Service
public class DBService {
	
	@Autowired
	private BCryptPasswordEncoder pe;

	@Autowired
	private UsuarioRepository usuarioRepository;
		
	public void instantiateTestDatabase() throws ParseException {

		
		
	}

}
