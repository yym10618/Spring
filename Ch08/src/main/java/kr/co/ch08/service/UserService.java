package kr.co.ch08.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.co.ch08.persistence.UserRepo;
import kr.co.ch08.vo.UserVo;

@Service
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepo repo;
	
	public void insertUser(UserVo vo) {
		
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		String pass = vo.getPass();
		vo.setPass(passwordEncoder.encode(vo.getPass()));
		
		repo.save(vo);
	}
	public UserVo selectUser(String uid) {
		return repo.findById(uid).get();
	}
	public List<UserVo> selectUsers() {
		return repo.findAll();
	}
	public void updateUser(UserVo vo) {
		repo.save(vo);
	}
	public void deleteUser(String uid) {
		repo.deleteById(uid);
	}
	
	// 인증관리필터에서 username 매개변수 DB로 넘겨서 검색 -> 해당 entity 검색
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

		UserVo userVo = repo.findById(username).get();
		
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
