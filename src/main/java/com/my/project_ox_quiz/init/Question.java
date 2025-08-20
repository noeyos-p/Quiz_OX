package com.my.project_ox_quiz.init;

import com.my.project_ox_quiz.entity.Quiz;
import com.my.project_ox_quiz.repository.QuizRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class Question implements CommandLineRunner {

    private final QuizRepository quizRepository;

    @Override
    public void run(String... args) throws Exception {
        if (quizRepository.count() > 0) {
            return;
        }
        Quiz quiz1 = new Quiz();
        quiz1.setQuestion("@PostMapping은 HTTP POST 요청을 처리하기 위한 어노테이션이다.");
        quiz1.setYes(true);
        quiz1.setNo(false);
        quiz1.setWriter("관리자");
        quizRepository.save(quiz1);

        Quiz quiz2 = new Quiz();
        quiz2.setQuestion("@GetMapping은 HTTP GET 요청을 처리하기 위한 어노테이션이다.");
        quiz2.setYes(true);
        quiz2.setNo(false);
        quiz2.setWriter("관리자");
        quizRepository.save(quiz2);

        Quiz quiz3 = new Quiz();
        quiz3.setQuestion("Spring MVC에서 controller, service, repository는 계층 분리를 통해 역할을 나눈다.");
        quiz3.setYes(true);
        quiz3.setNo(false);
        quiz3.setWriter("관리자");
        quizRepository.save(quiz3);

        Quiz quiz4 = new Quiz();
        quiz4.setQuestion("서비스 클래스에서는 컨트롤러 로직을 직접 구현해야 한다.");
        quiz4.setYes(false);
        quiz4.setNo(true);
        quiz4.setWriter("관리자");
        quizRepository.save(quiz4);

        Quiz quiz5 = new Quiz();
        quiz5.setQuestion("DTO는 Entity와 1:1 매핑되어야 하며, 필드 이름도 항상 같아야 한다.");
        quiz5.setYes(false);
        quiz5.setNo(true);
        quiz5.setWriter("관리자");
        quizRepository.save(quiz5);

        Quiz quiz6 = new Quiz();
        quiz6.setQuestion("Repository는 DB 접근 로직을 담당하는 레이어이며, @Repository 어노테이션을 붙여야 한다.");
        quiz6.setYes(true);
        quiz6.setNo(false);
        quiz6.setWriter("관리자");
        quizRepository.save(quiz6);

        Quiz quiz7 = new Quiz();
        quiz7.setQuestion("패키지를 도메인별로 분리하면, 관심사를 모듈 단위로 관리하기 수월하다.");
        quiz7.setYes(true);
        quiz7.setNo(false);
        quiz7.setWriter("관리자");
        quizRepository.save(quiz7);

        Quiz quiz8 = new Quiz();
        quiz8.setQuestion("@Controller는 뷰(JSP/HTML) 반환용이며, JSON 응답을 원하면 @RestController를 사용해야 한다.");
        quiz8.setYes(true);
        quiz8.setNo(false);
        quiz8.setWriter("관리자");
        quizRepository.save(quiz8);

        Quiz quiz9 = new Quiz();
        quiz9.setQuestion("@Service는 비즈니스 로직을 담는 클래스에 사용된다.");
        quiz9.setYes(true);
        quiz9.setNo(false);
        quiz9.setWriter("관리자");
        quizRepository.save(quiz9);

        Quiz quiz10 = new Quiz();
        quiz10.setQuestion("@Autowired를 사용하면 스프링이 자동으로 의존성을 주입해준다.");
        quiz10.setYes(true);
        quiz10.setNo(false);
        quiz10.setWriter("관리자");
        quizRepository.save(quiz10);

        Quiz quiz11 = new Quiz();
        quiz11.setQuestion("@RequestMapping은 URL 경로뿐 아니라 HTTP 메서드(GET, POST 등)도 지정할 수 있다.");
        quiz11.setYes(true);
        quiz11.setNo(false);
        quiz11.setWriter("관리자");
        quizRepository.save(quiz11);

        Quiz quiz12 = new Quiz();
        quiz12.setQuestion("@Entity 어노테이션은 해당 클래스가 DB 테이블과 매핑됨을 나타낸다.");
        quiz12.setYes(true);
        quiz12.setNo(false);
        quiz12.setWriter("관리자");
        quizRepository.save(quiz12);

        Quiz quiz13 = new Quiz();
        quiz13.setQuestion("@GetMapping('/user')은 GET 방식으로 '/user' URL을 처리한다.");
        quiz13.setYes(true);
        quiz13.setNo(false);
        quiz13.setWriter("관리자");
        quizRepository.save(quiz13);

        Quiz quiz14 = new Quiz();
        quiz14.setQuestion("컨트롤러 메서드에서는 Model model 파라미터를 통해 데이터를 템플릿에 전달할 수 있다.");
        quiz14.setYes(true);
        quiz14.setNo(false);
        quiz14.setWriter("관리자");
        quizRepository.save(quiz14);

        Quiz quiz15 = new Quiz();
        quiz15.setQuestion("컨트롤러에서 return '/user/list';와 같이 반환하면, templates/user/list.html을 렌더링한다.");
        quiz15.setYes(true);
        quiz15.setNo(false);
        quiz15.setWriter("관리자");
        quizRepository.save(quiz15);

        Quiz quiz16 = new Quiz();
        quiz16.setQuestion("스프링에서 @PathVariable은 쿼리 스트링 값을 가져올 때 사용한다.");
        quiz16.setYes(false);
        quiz16.setNo(true);
        quiz16.setWriter("관리자");
        quizRepository.save(quiz16);

        Quiz quiz17 = new Quiz();
        quiz17.setQuestion("@RequestParam은 폼에서 입력된 값을 메서드 인자로 받을 때 사용한다.");
        quiz17.setYes(true);
        quiz17.setNo(false);
        quiz17.setWriter("관리자");
        quizRepository.save(quiz17);

        Quiz quiz18 = new Quiz();
        quiz18.setQuestion("Entity 클래스는 데이터베이스 테이블과 직접 매핑되는 클래스이다.");
        quiz18.setYes(true);
        quiz18.setNo(false);
        quiz18.setWriter("관리자");
        quizRepository.save(quiz18);

        Quiz quiz19 = new Quiz();
        quiz19.setQuestion("DTO는 DB와 직접 연동되며, JPA 어노테이션을 포함해야 한다.");
        quiz19.setYes(false);
        quiz19.setNo(true);
        quiz19.setWriter("관리자");
        quizRepository.save(quiz19);

        Quiz quiz20 = new Quiz();
        quiz20.setQuestion("Repository는 JpaRepository를 상속받아 기본 CRUD 기능을 사용할 수 있다.");
        quiz20.setYes(true);
        quiz20.setNo(false);
        quiz20.setWriter("관리자");
        quizRepository.save(quiz20);

        Quiz quiz21 = new Quiz();
        quiz21.setQuestion("Entity에는 기본 생성자가 반드시 있어야 한다.");
        quiz21.setYes(true);
        quiz21.setNo(false);
        quiz21.setWriter("관리자");
        quizRepository.save(quiz21);

        Quiz quiz22 = new Quiz();
        quiz22.setQuestion("DTO는 외부 요청 및 응답용이며, Entity는 내부 비즈니스용이다.");
        quiz22.setYes(true);
        quiz22.setNo(false);
        quiz22.setWriter("관리자");
        quizRepository.save(quiz22);

        Quiz quiz23 = new Quiz();
        quiz23.setQuestion("서비스 계층에서는 트랜잭션 처리나 복합 로직을 담당한다.");
        quiz23.setYes(true);
        quiz23.setNo(false);
        quiz23.setWriter("관리자");
        quizRepository.save(quiz23);

        Quiz quiz24 = new Quiz();
        quiz24.setQuestion("컨트롤러가 직접 DB 접근을 해도 성능에 문제만 없다면 괜찮다.");
        quiz24.setYes(false);
        quiz24.setNo(true);
        quiz24.setWriter("관리자");
        quizRepository.save(quiz24);

        Quiz quiz25 = new Quiz();
        quiz25.setQuestion("서비스 클래스는 일반적으로 인터페이스를 두고, 구현체를 분리하는 것이 좋다.");
        quiz25.setYes(true);
        quiz25.setNo(false);
        quiz25.setWriter("관리자");
        quizRepository.save(quiz25);

        Quiz quiz26 = new Quiz();
        quiz26.setQuestion("서비스는 컨트롤러로부터 DTO를 받아 Repository에 Entity를 전달하는 역할을 한다.");
        quiz26.setYes(true);
        quiz26.setNo(false);
        quiz26.setWriter("관리자");
        quizRepository.save(quiz26);

        Quiz quiz27 = new Quiz();
        quiz27.setQuestion("templates 폴더 안에 있는 HTML 파일들은 Thymeleaf 같은 템플릿 엔진이 렌더링한다");
        quiz27.setYes(true);
        quiz27.setNo(false);
        quiz27.setWriter("관리자");
        quizRepository.save(quiz27);

        Quiz quiz28 = new Quiz();
        quiz28.setQuestion("Spring MVC에서는 템플릿 이름을 직접 URL로 접근해도 브라우저에 출력된다.");
        quiz28.setYes(false);
        quiz28.setNo(true);
        quiz28.setWriter("관리자");
        quizRepository.save(quiz28);

        Quiz quiz29 = new Quiz();
        quiz29.setQuestion("model.addAttribute('user', userDto)는 뷰 템플릿에서 ${user}로 접근 가능하게 한다.");
        quiz29.setYes(true);
        quiz29.setNo(false);
        quiz29.setWriter("관리자");
        quizRepository.save(quiz29);

        Quiz quiz30 = new Quiz();
        quiz30.setQuestion("application.properties 파일은 DB 설정, 뷰 리졸버, 포트 설정 등 애플리케이션 설정에 사용된다.");
        quiz30.setYes(true);
        quiz30.setNo(false);
        quiz30.setWriter("관리자");
        quizRepository.save(quiz30);
    }
}
