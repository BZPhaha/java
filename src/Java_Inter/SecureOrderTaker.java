package Java_Inter;

import java.io.FileInputStream;
import java.io.InputStream;
import java.net.Socket;
import java.security.KeyStore;
import java.util.Arrays;

import javax.net.ssl.KeyManagerFactory;
import javax.net.ssl.SSLContext;
import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;

public class SecureOrderTaker {
	public final static int PORT = 7000;
	public final static String algorithm = "SSL";
	public static void main(String[] args){
		try {
			SSLContext context = SSLContext.getInstance(algorithm);
			KeyManagerFactory kmf = KeyManagerFactory.getInstance("SunX509");
			KeyStore ks = KeyStore.getInstance("JKS");
			char[] password = System.console().readPassword();
			ks.load(new FileInputStream("jnp4e.keys"),password);
			context.init(kmf.getKeyManagers(), null, null);
			Arrays.fill(password, '0');
			SSLServerSocketFactory factory = context.getServerSocketFactory();
			SSLServerSocket server = (SSLServerSocket) factory.createServerSocket(PORT);
			//增加匿名 密码组
			String[] supported = server.getSupportedCipherSuites();
			String[] anonCipherSuitesSupported = new String[supported.length];
			int numAnonCipherSuitesSupported = 0;
			for(int i = 0;i < supported.length; i++){
				if(supported[i].indexOf("_anon_") > 0){
					anonCipherSuitesSupported[numAnonCipherSuitesSupported++] = supported[i];
				}
			}
			String[] oldEnabled = server.getEnabledCipherSuites();
			String[] newEnabled  = new String[oldEnabled.length + numAnonCipherSuitesSupported];
			System.arraycopy(oldEnabled, 0, newEnabled, 0, oldEnabled.length);
			System.arraycopy(anonCipherSuitesSupported, 0, newEnabled, oldEnabled.length,numAnonCipherSuitesSupported);
			server.setEnabledCipherSuites(newEnabled);
			while(true){
				try (Socket theConnection = server.accept()){
					InputStream  in = theConnection.getInputStream();
					int c;
					while((c = in.read()) != -1){
						System.out.println(c);
					}
				} catch (Exception e) {
					// TODO: handle exception
					e.printStackTrace();
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
	}
}
