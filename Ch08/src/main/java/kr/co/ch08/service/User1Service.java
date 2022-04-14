package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.persistence.User1Repo;
import kr.co.ch08.vo.User1Vo;

@Service
public class User1Service implements UserDetailsService {

	@Autowired
	private User1Repo repo;
	
	public void insertUser(User1Vo vo) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = vo.getPass();
		vo.setPass(passwordEncoder.encode(vo.getPass()));
		
		repo.save(vo);
	}
	public User1Vo selectUser(String uid) {
		return repo.findById(uid).get();
	}
	public List<User1Vo> selectUsers() {
		return repo.findAll();
	}
	public void updateUser(User1Vo vo) {
		repo.save(vo);
	}
	public void deleteUser(String uid) {
		repo.deleteById(uid);
	}
	
	// 인증관리필터에서 username 매개변수 DB로 넘겨서 검색 -> 해당 entity 검색
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		User1Vo userVo = repo.findById(username).get();
		
		if(userVo == null) {
			System.out.println("user 없음!");
			throw new UsernameNotFoundException(username);
		}
		
		// 로그인 인증 처리 메서드(SecurityConfig에서 설정)
		return User.builder()
				.username(userVo.getUid())
				.password(userVo.getPass())
				.roles("USER")
				.build();
	}

}
