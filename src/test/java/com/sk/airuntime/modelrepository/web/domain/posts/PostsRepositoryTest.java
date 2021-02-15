package com.sk.airuntime.modelrepository.web.domain.posts;

import com.sk.airuntime.modelrepository.domain.posts.Posts;
import com.sk.airuntime.modelrepository.domain.posts.PostsRepository;
import org.junit.After;
import org.junit.Test;
import org.junit.runner.RunWith;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class) // @Runwith는 JUnit에 내장된 실행자 외에 다른 실행자를 실행시킴. SpringRunner라는 실행자. 스프링 부트 테스트와 JUnit 사이 연결자.
@SpringBootTest // 별다른 설정없이 @SpringBootTest를 할 경우 H2 데이터베이스를 자동으로 실행.
public class PostsRepositoryTest {

    @Autowired // 스프링이 관리하는 빈 Bean 주입.
    PostsRepository postsRepository;

    @After // JUnit에서 단위 테스트가 끝날 때마다 수행되는 메소드를 지, 보통은 배포 전 전체 테스트를 수행할 때 테스트 간 데이터 침범을 막기위해 사용.
    // 여러 테스트가 동시에 수행되면 테스트용 데이터 베이스인 H2에 데이터가 그대로 남아있어 다음 테스트 실행 시 테스트 실패 가능
    public void cleanup() {
        postsRepository.deleteAll();
    }

    @Test
    public void 게시글저장_불러오기() {
        //given
        String title = "테스트 게시글";
        String content = "테스트 본문";

        postsRepository.save(Posts.builder() //테이블 posts에 insert/update 쿼리 실행. id값이 있다면 update 없으면 insert
                .title(title)
                .content(content)
                .author("beholder16@gmail.com")
                .build());

        //when
        List<Posts> postsList = postsRepository.findAll(); // 테이블 posts에 있는 모든 데이터를 조회해오는 메소드.

        //then
        Posts posts  = postsList.get(0);
        assertThat(posts.getTitle()).isEqualTo(title); //assertj라는 테스트 검증 라이브러리의 검증 메소드, 검증 대상을 인자로 받음. postlist에서 첫번째를 갖고오나
        assertThat(posts.getContent()).isEqualTo(content);
    }


}
