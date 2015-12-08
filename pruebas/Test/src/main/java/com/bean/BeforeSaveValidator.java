package com.bean;

import java.util.Set;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import javax.validation.Validator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.mapping.event.AbstractMongoEventListener;
import org.springframework.stereotype.Component;

import com.mongodb.DBObject;

@Component
public class BeforeSaveValidator extends AbstractMongoEventListener<Object> {
 
    @Autowired
    private Validator validator;
 
    @Override
    public void onBeforeSave(Object source, DBObject dbo) {
        Set<ConstraintViolation<Object>> violations = validator.validate(source);
 
        if (violations.size() > 0) {
            throw new ConstraintViolationException(violations);
        }
    }
}