package com.erning.exchange.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.erning.exchange.service.BaseService;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;

import javax.annotation.Resource;

/**
 * ScheduleTaskService
 * 定时任务相关
 * Cron有如下两种语法格式：
 * 1.Seconds Minutes Hours DayofMonth Month DayofWeek Year
 * 2.Seconds Minutes Hours DayofMonth Month DayofWeek
 *
 * 每一个域可出现的字符如下：
 * Seconds: 可出现", - * /"四个字符，有效范围为0-59的整数
 * Minutes: 可出现", - * /"四个字符，有效范围为0-59的整数
 * Hours: 可出现", - * /"四个字符，有效范围为0-23的整数
 * DayofMonth :可出现", - * / ? L W C"八个字符，有效范围为0-31的整数
 * Month: 可出现", - * /"四个字符，有效范围为1-12的整数或JAN-DEc
 * DayofWeek: 可出现", - * / ? L C #"四个字符，有效范围为1-7的整数或SUN-SAT两个范围。1表示星期天，2表示星期一， 依次类推
 * Year: 可出现", - * /"四个字符，有效范围为1970-2099年
 *
 * 每一个域都使用数字，但还可以出现如下特殊字符，它们的含义是：
 * (1) *：表示所有值。 例如:在分的字段上设置 *,表示每一分钟都会触发。
 * (2) ?：表示不指定值。使用的场景为不需要关心当前设置这个字段的值。例如:要在每月的10号触发一个操作，但不关心是周几，所以需要周位置的那个字段设置为”?” 具体设置为 0 0 0 10 * ?
 * (3) -：表示区间。例如 在小时上设置 “10-12”,表示 10,11,12点都会触发。
 * (4) /：用于递增触发。如在秒上面设置”5/15” 表示从5秒开始，每增15秒触发(5,20,35,50)。 在月字段上设置’1/3’所示每月1号开始，每隔三天触发一次。
 * (5) ,：表示指定多个值，例如在周字段上设置 “MON,WED,FRI” 表示周一，周三和周五触发
 * (6) L：表示最后的意思。在日字段设置上，表示当月的最后一天(依据当前月份，如果是二月还会依据是否是润年[leap]), 在周字段上表示星期六，相当于”7”或”SAT”。如果在”L”前加上数字，则表示该数据的最后一个。例如在周字段上设置”6L”这样的格式,则表示“本月最后一个星期五”
 * (7) W：表示离指定日期的最近那个工作日(周一至周五). 例如在日字段上置”15W”，表示离每月15号最近的那个工作日触发。如果15号正好是周六，则找最近的周五(14号)触发, 如果15号是周未，则找最近的下周一(16号)触发.如果15号正好在工作日(周一至周五)，则就在该天触发。如果指定格式为 “1W”,它则表示每月1号往后最近的工作日触发。如果1号正是周六，则将在3号下周一触发。(注，”W”前只能设置具体的数字,不允许区间”-“)。
 * (8) LW：这两个字符可以连用，表示在某个月最后一个工作日，即最后一个星期五。
 * (9) #：序号(表示每月的第几个周几)，例如在周字段上设置”6#3”表示在每月的第三个周六.注意如果指定”#5”,正好第五周没有周六，则不会触发该配置(用在母亲节和父亲节再合适不过了) ；小提示：’L’和 ‘W’可以一组合使用。如果在日字段上设置”LW”,则表示在本月的最后一个工作日触发；周字段的设置，若使用英文字母是不区分大小写的，即MON与mon相同。
 *
 * 举几个例子:
 *每隔5秒执行一次："*\/5 * * * * ?"
 *每隔1分钟执行一次："0 *\/1 * * * ?"
 *每天23点执行一次："0 0 23 * * ?"
 *每天凌晨1点执行一次："0 0 1 * * ?"
 *每月1号凌晨1点执行一次："0 0 1 1 * ?"
 *每月最后一天23点执行一次："0 0 23 L * ?"
 *每周星期天凌晨1点实行一次："0 0 1 ? * L"
 *在26分、29分、33分执行一次："0 26,29,33 * * * ?"
 *每天的0点、13点、18点、21点都执行一次："0 0 0,13,18,21 * * ?"
 *表示在每月的1日的凌晨2点调度任务："0 0 2 1 * ? *"
 *表示周一到周五每天上午10：15执行作业："0 15 10 ? * MON-FRI"
 *表示2002-2006年的每个月的最后一个星期五上午10:15执行："0 15 10 ? 6L 2002-2006"
 *
 * 2019/12
 * 二宁
 */
@Configuration      //1.主要用于标记配置类，兼备Component的效果。
@EnableScheduling   // 2.开启定时任务
public class ScheduleTask {
    @Resource
    private BaseService baseService;

    @Scheduled(cron = "0 0 */2 * * ?")
    private void update() {
        baseService.update();
    }
}
