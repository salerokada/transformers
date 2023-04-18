package com.rokada.transformers.interceptor;

import com.rokada.transformers.exception.TransformerException;
import com.rokada.transformers.model.ElementRequestWrapper;
import com.rokada.transformers.model.ElementResponseWrapper;
import com.rokada.transformers.service.TransformationService;
import java.util.Arrays;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
@RequiredArgsConstructor
public class TransformerAspect {

  private final TransformationService transformationService;

  @Pointcut("@annotation(com.rokada.transformers.interceptor.Transformer)")
  private void transform() {
  }

  @Around("transform()")
  public Object processTransformation(ProceedingJoinPoint pjp) throws Throwable {
    Optional<Object> elementWrapperOptional = Arrays.stream(pjp.getArgs()).findFirst();
    if (elementWrapperOptional.isPresent()
        && elementWrapperOptional.get() instanceof ElementRequestWrapper elementRequestWrapper) {
      ElementResponseWrapper response = transformationService.processData(elementRequestWrapper);

      throw new TransformerException("Dummy exception", elementRequestWrapper, response);
    }
    return pjp.proceed();
  }

}
