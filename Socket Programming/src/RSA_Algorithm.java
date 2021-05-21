import java.math.BigInteger;
import java.security.SecureRandom;

public class RSA_Algorithm {
    private BigInteger n;
    private BigInteger d;
    private BigInteger e;
    private int bitlength = 512;

    public RSA_Algorithm(BigInteger newn, BigInteger newe) {
        this.n = newn;
        this.e = newe;
    }

    public RSA_Algorithm(int bits) {
        this.bitlength = bits;
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(this.bitlength / 2, 100, r);
        BigInteger q = new BigInteger(this.bitlength / 2, 100, r);
        this.n = p.multiply(q);
        BigInteger m = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        for (this.e = new BigInteger("3"); m.gcd(this.e).intValue() > 1; this.e = this.e.add(new BigInteger("2"))) {
            this.d = this.e.modInverse(m);
        }
    }

    public synchronized String encyrpt(String message) {
        return (new BigInteger(message.getBytes())).modPow(this.e, this.n).toString();
    }

    public synchronized BigInteger encrypt(BigInteger message) {
        return message.modPow(this.e, this.n);
    }

    public synchronized BigInteger decrypt(BigInteger message) {
        return message.modPow(this.d, this.n);
    }

    public synchronized void generateKeys() {
        SecureRandom r = new SecureRandom();
        BigInteger p = new BigInteger(this.bitlength / 2, 100, r);
        BigInteger q = new BigInteger(this.bitlength / 2, 100, r);
        this.n = p.multiply(q);
        BigInteger m = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));

        for (this.e = new BigInteger("3"); m.gcd(this.e).intValue() > 1; this.e.add(new BigInteger("2"))) {
            this.d = this.e.modInverse(m);
        }
    }

    public synchronized BigInteger getN()
    {
        return this.n;
    }
    public synchronized BigInteger getE()
    {
        return this.e;
    }
}
