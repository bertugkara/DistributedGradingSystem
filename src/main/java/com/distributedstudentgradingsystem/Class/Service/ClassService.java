package com.distributedstudentgradingsystem.Class.Service;

import com.distributedstudentgradingsystem.Class.Entity.Class;
import com.distributedstudentgradingsystem.utilities.Result;

import java.util.List;

public interface ClassService {

    Result addPojoClass(Class pojoClass);

    List<Class> getAllClasses();

}
