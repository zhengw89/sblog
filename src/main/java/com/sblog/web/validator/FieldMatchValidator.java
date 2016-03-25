package com.sblog.web.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.springframework.beans.BeanWrapperImpl;

public class FieldMatchValidator implements ConstraintValidator<FieldMatch, Object>
{
    private String firstFieldName;
    private String secondFieldName;

    public void initialize(final FieldMatch constraintAnnotation)
    {
        firstFieldName = constraintAnnotation.first();
        secondFieldName = constraintAnnotation.second();
    }

    public boolean isValid(final Object value, final ConstraintValidatorContext context)
    {
        try
        {
            final Object firstObj = this.getObjectProperty(value, firstFieldName);
            final Object secondObj = this.getObjectProperty(value, secondFieldName);
            
            return firstObj == null && secondObj == null || firstObj != null && firstObj.equals(secondObj);
        }
        catch (final Exception ignore)
        {
        	return false;
        }
    }
    
    private Object getObjectProperty(Object targetObj, String propertyName){
    	BeanWrapperImpl wrapper = new BeanWrapperImpl(targetObj);
    	return wrapper.getPropertyValue(propertyName);
    }
}
