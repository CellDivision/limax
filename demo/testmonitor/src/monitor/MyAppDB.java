package monitor;

import limax.sql.SQLPooledExecutor;
import limax.util.monitor.MonitorCollector;

public class MyAppDB {

	public static void main(String[] args) throws Exception {
		String url = "jdbc:mysql://192.168.1.3:3306/test?user=root&password=admin";
		SQLPooledExecutor sqlExecutor = new SQLPooledExecutor(url, 5);
		MonitorCollector mc = new MonitorCollector((host, exception) -> exception.printStackTrace());
		try {
			mc.addHost("testhost", MonitorCollector.formatJMXServiceURLString("localhost", 10202, 10201), null, null);
			mc.addSQLExecutor(sqlExecutor);
			mc.addCollector("testhost", testmonitor.AuthProvider.Collector.buildObjectNameQueryString(null, null),
					1000);
			mc.addCollector("testhost", testmonitor.Online.Collector.buildObjectNameQueryString(null, null, null),
					1000);
			Thread.sleep(100);
		} finally {
			mc.stop();
			sqlExecutor.shutdown();
		}
	}
}
