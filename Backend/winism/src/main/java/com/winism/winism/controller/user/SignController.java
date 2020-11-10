package com.winism.winism.controller.user;

import com.winism.winism.advice.exception.CEmailSigninFailedException;
import com.winism.winism.config.security.JwtTokenProvider;
import com.winism.winism.entity.User;
import com.winism.winism.model.response.CommonResult;
import com.winism.winism.model.response.SingleResult;
import com.winism.winism.repo.UserJpaRepo;
import com.winism.winism.service.ResponseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Map;

@Api(tags = {"1. Sign"})
@RequiredArgsConstructor
@RestController
@RequestMapping(value = "/v1")
public class SignController {

    private final UserJpaRepo userJpaRepo;
    private final JwtTokenProvider jwtTokenProvider;
    private final ResponseService responseService;
    private final PasswordEncoder passwordEncoder;

    @ApiOperation(value = "로그인", notes = "이메일 회원 로그인을 한다.")
    @PostMapping(value = "/signin")
    public SingleResult<String> signin(@RequestBody Map<String, String> data) {
        System.out.println("로그인 요청");
        User user = userJpaRepo.findByUserid(data.get("email")).orElseThrow(CEmailSigninFailedException::new);
        if (!passwordEncoder.matches(data.get("password"), user.getPassword()))
            throw new CEmailSigninFailedException();
        System.out.println("토큰 발급 전");
        return responseService.getSingleResult(jwtTokenProvider.createToken(String.valueOf(user.getUid()), user.getRoles()));

    }

    @ApiOperation(value = "가입", notes = "회원가입을 한다.")
    @PostMapping(value = "/signup")
    public CommonResult signup(@RequestBody Map<String, String> data) {
        System.out.println("회원가입");
        userJpaRepo.save(User.builder()
                .userid(data.get("email"))
                .password(passwordEncoder.encode(data.get("password")))
                .gender(data.get("gender"))
                .age(Integer.parseInt(data.get("age")))
                .roles(Collections.singletonList("ROLE_USER"))
                .build());
        return responseService.getSuccessResult();
    }
}