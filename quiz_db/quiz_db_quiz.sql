CREATE DATABASE  IF NOT EXISTS `quiz_db` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;
USE `quiz_db`;
-- MySQL dump 10.13  Distrib 8.0.42, for Win64 (x86_64)
--
-- Host: localhost    Database: quiz_db
-- ------------------------------------------------------
-- Server version	8.0.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `quiz`
--

DROP TABLE IF EXISTS `quiz`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `quiz` (
  `no` bit(1) NOT NULL,
  `yes` bit(1) NOT NULL,
  `id` bigint NOT NULL AUTO_INCREMENT,
  `question` varchar(255) DEFAULT NULL,
  `writer` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `quiz`
--

LOCK TABLES `quiz` WRITE;
/*!40000 ALTER TABLE `quiz` DISABLE KEYS */;
INSERT INTO `quiz` VALUES (_binary '',_binary '\0',1,'@PostMapping은 HTTP POST 요청을 처리하기','박소연'),(_binary '\0',_binary '',2,'@GetMapping은 HTTP GET 요청을 처리하기 위한 어노테이션이다.','관리자'),(_binary '\0',_binary '',3,'Spring MVC에서 controller, service, repository는 계층 분리를 통해 역할을 나눈다.','관리자'),(_binary '',_binary '\0',4,'서비스 클래스에서는 컨트롤러 로직을 직접 구현해야 한다.','관리자'),(_binary '',_binary '\0',5,'DTO는 Entity와 1:1 매핑되어야 하며, 필드 이름도 항상 같아야 한다.','관리자'),(_binary '\0',_binary '',6,'Repository는 DB 접근 로직을 담당하는 레이어이며, @Repository 어노테이션을 붙여야 한다.','관리자'),(_binary '\0',_binary '',7,'패키지를 도메인별로 분리하면, 관심사를 모듈 단위로 관리하기 수월하다.','관리자'),(_binary '\0',_binary '',8,'@Controller는 뷰(JSP/HTML) 반환용이며, JSON 응답을 원하면 @RestController를 사용해야 한다.','관리자'),(_binary '\0',_binary '',9,'@Service는 비즈니스 로직을 담는 클래스에 사용된다.','관리자'),(_binary '\0',_binary '',10,'@Autowired를 사용하면 스프링이 자동으로 의존성을 주입해준다.','관리자'),(_binary '\0',_binary '',11,'@RequestMapping은 URL 경로뿐 아니라 HTTP 메서드(GET, POST 등)도 지정할 수 있다.','관리자'),(_binary '\0',_binary '',12,'@Entity 어노테이션은 해당 클래스가 DB 테이블과 매핑됨을 나타낸다.','관리자'),(_binary '\0',_binary '',13,'@GetMapping(\'/user\')은 GET 방식으로 \'/user\' URL을 처리한다.','관리자'),(_binary '\0',_binary '',14,'컨트롤러 메서드에서는 Model model 파라미터를 통해 데이터를 템플릿에 전달할 수 있다.','관리자'),(_binary '\0',_binary '',15,'컨트롤러에서 return \'/user/list\';와 같이 반환하면, templates/user/list.html을 렌더링한다.','관리자'),(_binary '',_binary '\0',16,'스프링에서 @PathVariable은 쿼리 스트링 값을 가져올 때 사용한다.','관리자'),(_binary '\0',_binary '',17,'@RequestParam은 폼에서 입력된 값을 메서드 인자로 받을 때 사용한다.','관리자'),(_binary '\0',_binary '',18,'Entity 클래스는 데이터베이스 테이블과 직접 매핑되는 클래스이다.','관리자'),(_binary '',_binary '\0',19,'DTO는 DB와 직접 연동되며, JPA 어노테이션을 포함해야 한다.','관리자'),(_binary '\0',_binary '',20,'Repository는 JpaRepository를 상속받아 기본 CRUD 기능을 사용할 수 있다.','관리자'),(_binary '\0',_binary '',21,'Entity에는 기본 생성자가 반드시 있어야 한다.','관리자'),(_binary '\0',_binary '',22,'DTO는 외부 요청 및 응답용이며, Entity는 내부 비즈니스용이다.','관리자'),(_binary '\0',_binary '',23,'서비스 계층에서는 트랜잭션 처리나 복합 로직을 담당한다.','관리자'),(_binary '',_binary '\0',24,'컨트롤러가 직접 DB 접근을 해도 성능에 문제만 없다면 괜찮다.','관리자'),(_binary '\0',_binary '',25,'서비스 클래스는 일반적으로 인터페이스를 두고, 구현체를 분리하는 것이 좋다.','관리자'),(_binary '\0',_binary '',26,'서비스는 컨트롤러로부터 DTO를 받아 Repository에 Entity를 전달하는 역할을 한다.','관리자'),(_binary '\0',_binary '',27,'templates 폴더 안에 있는 HTML 파일들은 Thymeleaf 같은 템플릿 엔진이 렌더링한다','관리자'),(_binary '',_binary '\0',28,'Spring MVC에서는 템플릿 이름을 직접 URL로 접근해도 브라우저에 출력된다.','관리자'),(_binary '\0',_binary '',29,'model.addAttribute(\'user\', userDto)는 뷰 템플릿에서 ${user}로 접근 가능하게 한다.','관리자'),(_binary '\0',_binary '',30,'application.properties 파일은 DB 설정, 뷰 리졸버, 포트 설정 등 애플리케이션 설정에 사용된다.','관리자');
/*!40000 ALTER TABLE `quiz` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2025-08-20 17:15:57
