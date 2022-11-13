package com.todo.javatodo.aop

import org.apache.logging.log4j.LogManager
import org.apache.logging.log4j.Logger
import org.aspectj.lang.ProceedingJoinPoint
import org.aspectj.lang.annotation.Around
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.reflect.MethodSignature
import org.springframework.stereotype.Component
import org.springframework.util.StopWatch

@Aspect
@Component
class LoggingAspect {

    companion object {
        val log: Logger = LogManager.getLogger(LoggingAspect::class.java.name)
    }

    @Around("execution(* com.todo.javatodo.controller..*(..)))")
    fun profileControllerMethods(proceedingJoinPoint: ProceedingJoinPoint): Any {

        // считываем метаданные - что сейчас выполняется
        val methodSignature = proceedingJoinPoint.signature as MethodSignature

        // получить информацию о том, какой класс и метод выполняется
        val className = methodSignature.declaringType.simpleName
        val methodName = methodSignature.name
        log.info("-------- Executing $className.$methodName   ----------- ")

        val countdown = StopWatch()

        countdown.start()
        val result = proceedingJoinPoint.proceed() // выполняем сам метод
        countdown.stop()

        log.info("-------- Execution time of " + className + "." + methodName + " :: " + countdown.totalTimeMillis + " ms")
        return result
    }
}