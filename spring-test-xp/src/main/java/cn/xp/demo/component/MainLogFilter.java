package cn.xp.demo.component;


import ch.qos.logback.classic.spi.ILoggingEvent;
import ch.qos.logback.core.filter.Filter;
import ch.qos.logback.core.spi.FilterReply;

/**
 * 主日志过滤器
 * @author pxc
 * logback配置：
 * <appender ...>
 * 		...
 * 		<filter class="cn.richinfo.finance.common.logfilter.ReportLogFilter" />
 * </appender>
 */
public class MainLogFilter extends Filter<ILoggingEvent> {


    @Override
    public FilterReply decide(ILoggingEvent arg0) {
            return FilterReply.ACCEPT;//允许输出日志
        }
    }