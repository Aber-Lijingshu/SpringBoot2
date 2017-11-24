package com.demo.scheduling;

import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

/**
 * @ClassName: SchedulingConfig
 * @Description: ��ʱ����
 * @author shuyu.wang
 * @date 2017��11��23�� ����10:25:57
 * @version V1.0
 */
@Configuration
@EnableScheduling
public class SchedulingConfig {
	@Scheduled(cron = "0/20 * * * * ?") // ÿ20��ִ��һ��
	public void scheduler() {
//		System.out.println(">>>>>>>>> SchedulingConfig.scheduler()");
	}

}
