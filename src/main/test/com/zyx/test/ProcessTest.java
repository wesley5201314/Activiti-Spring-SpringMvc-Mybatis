package com.zyx.test;

import org.activiti.engine.*;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.runtime.ProcessInstance;
import org.activiti.engine.task.Task;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by Ethel_oo on 2017/12/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring/applicationContext.xml"})
@TransactionConfiguration(transactionManager="transactionManager", defaultRollback=false)
@Transactional
public class ProcessTest extends AbstractTransactionalJUnit4SpringContextTests{
    @Autowired
    private ProcessEngine processEngine;
    @Autowired
    private RepositoryService repositoryService;
    @Autowired
    private RuntimeService runtimeService;
    @Autowired
    private TaskService taskService;

    @Test
    public void test() {
        System.out.println("*********************** 流程开始 ***************************");



        // 1、部署流程文件
        Deployment deployment = repositoryService.createDeployment().name("activiti_test01")
                .addClasspathResource("bpmn/activiti_test01.bpmn20.xml").deploy();
        System.out.println("----"+deployment.getId()+"---name-"+deployment.getName());

        // 2、启动流程
        ProcessInstance processInstance = runtimeService.startProcessInstanceByKey("activiti_test01");
        System.out.println("流程实例ID=" + processInstance.getId());

        // 3、查询第一个任务
        Task task = taskService.createTaskQuery().singleResult();
        System.out.println("任务ID=" + task.getId() + "  任务名称=" + task.getName());
        taskService.complete(task.getId()); // 完成任务

        // 4、查询第二个任务
        task = taskService.createTaskQuery().singleResult();
        System.out.println("任务ID=" + task.getId() + "  任务名称=" + task.getName());
        taskService.complete(task.getId()); // 完成任务

        // 5、流程结束
        task = taskService.createTaskQuery().singleResult();
        System.out.println("任务结束（" + task + "）");
        // 流程结束
        System.out.println("*********************** 流程结束 ***************************");
    }
}
