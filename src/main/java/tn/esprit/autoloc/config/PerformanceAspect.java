package tn.esprit.autoloc.config;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
@Aspect
@Slf4j
public class PerformanceAspect {
    @Around("execution(* tn.esprit.autoloc.services..*(..))")
    public Object mesurerPerformance(ProceedingJoinPoint joinPoint) throws Throwable {
        long debut = System.currentTimeMillis();
        Object resultat = joinPoint.proceed();
        long fin = System.currentTimeMillis();
        long duree = fin - debut;
        // Afficher le temps d'exécution
        System.out.println("Méthode : " + joinPoint.getSignature().getName());
        System.out.println("Temps d'exécution : " + duree + " ms");
        if (duree > 1000) { // Signaler les méthodes dépassant 1000 ms
            System.out.println("ATTENTION : Temps d'exécution supérieur à 1000 ms !");
        }
        return resultat;
    }
}
