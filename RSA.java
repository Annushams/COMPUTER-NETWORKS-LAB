//Key Generation part
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
class RSA
{
public static void main(String[] args)
{
Random r = new Random();
Random r2 = new Random();
int e = Integer.parseInt(args[0]);
BigInteger p = BigInteger.probablePrime(4,r);
BigInteger q = BigInteger.probablePrime(4,r2);
BigInteger n = p.multiply(q);
BigInteger p1 = p.subtract(new BigInteger("1"));
BigInteger q1 = q.subtract(new BigInteger("1"));
BigInteger phi = p1.multiply(q1);
while(true)
{
BigInteger GCD = phi.gcd(new BigInteger(""+e));
if(GCD.equals(BigInteger.ONE))
{
break;
}
e++;
}
BigInteger a = new BigInteger(""+e);
BigInteger d = a.modInverse(phi);
System.out.println("public key:"+a+","+n);
System.out.println("Detection key:"+d+","+n);
}
}


//Encryption and Decryption part
import java.util.*;
import java.math.BigInteger;
import java.lang.*;
class ed {
public static void main(String[] args) {
BigInteger pubKey = new BigInteger(args[0]);
 BigInteger prvKey = new BigInteger(args[1]);
BigInteger n = new BigInteger(args[2]);
 int asciiVal = Integer.parseInt(args[3]);
 BigInteger val = new BigInteger(""+ asciiVal);
 BigInteger cKey = val.modPow(pubKey,n);
System.out.println("Cipher Text: " + cKey);
BigInteger pVal = cKey.modPow(prvKey,n);
int Pval = pVal.intValue();
System.out.println("Plain text: " + Pval);
}
}