package tn.esprit.autoloc.config;


import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class ExceptionHandlingAspect {
    @AfterThrowing(
            pointcut = "execution(* tn.esprit.autoloc.services..*(..))",
            throwing = "exception"
    )
    public void gererException(JoinPoint joinPoint, Throwable exception) {
        System.out.println("ERREUR DETECTEE");
        // nom de la méthode concernée
        System.out.println("Méthode : "
                + joinPoint.getSignature().getName());
        // type de l'exception
        System.out.println("Type d'exception : "
                + exception.getClass().getSimpleName());
        // msg d'erreur
        System.out.println("Message : "
                + exception.getMessage());
    }

}
