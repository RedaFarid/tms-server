package TMSserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
public class TmsServerApplication {

    public static void main(String[] args) /*throws IOException */{
        SpringApplication.run(TmsServerApplication.class, args);
//        InetAddress localhost = InetAddress.getLocalHost();
//        //  IPv4
//        byte[] ip = localhost.getAddress();
//
//        for (int i = 1; i <= 254; i++) {
//            ip[3] = (byte) i;
//
//			InetAddress host = InetAddress.getByAddress(ip);
//
//            if (host.isReachable(1000)) {
//                System.out.println(host + "            " + "Device Name: " + host.getHostName());
//
//            }
//        }
    }
}
