package life.majiang.community.controller;

import life.majiang.community.dto.AcessTokenDTO;
import life.majiang.community.provider.GithubProvider;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthorizeController {
    @Autowired
    private GithubProvider githubProvider;

    @GetMapping
    public String callback(@RequestParam(name="code") String code,
                           @RequestParam(name="state") String state){
        AcessTokenDTO acessTokenDTO = new AcessTokenDTO();
        acessTokenDTO.setClient_id("Iv1.50bdf890e2a6752a");
        acessTokenDTO.setRedirect_uri("http://localhost:8887/callback");
        acessTokenDTO.setClient_secret("df8e8ab3b73e9232bf4d557d15e576b31f20c75d");
        acessTokenDTO.setCode(code);
        acessTokenDTO.setState(state);
        githubProvider.getAcessToken(acessTokenDTO);
        return "index";
    }
}
