package saltoInLungo;

public class Atleta {
	private String nome;
	private double s;
	private double s1;
	private double s2;
	private double s3;

	public Atleta(String nome, double s1, double s2, double s3) {
		super();
		this.nome = nome;
		this.s1 = s1;
		this.s2 = s2;
		this.s3 = s3;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public double getS() {
		return s;
	}

	public void setS() {
		s = 0;
		if (this.s1 > s) {
			s = this.s1;
		}
		if (this.s2 > s) {
			s = this.s2;
		}
		if (this.s3 > s) {
			s = this.s3;
		}
	}

	public double getS1() {
		return s1;
	}

	public void setS1(double s1) {
		this.s1 = s1;
	}

	public double getS2() {
		return s2;
	}

	public void setS2(double s2) {
		this.s2 = s2;
	}

	public double getS3() {
		return s3;
	}

	public void setS3(double s3) {
		this.s3 = s3;
	}

	public void Registra() {

	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		long temp;
		temp = Double.doubleToLongBits(s);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(s1);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(s2);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(s3);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Atleta other = (Atleta) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Double.doubleToLongBits(s) != Double.doubleToLongBits(other.s))
			return false;
		if (Double.doubleToLongBits(s1) != Double.doubleToLongBits(other.s1))
			return false;
		if (Double.doubleToLongBits(s2) != Double.doubleToLongBits(other.s2))
			return false;
		if (Double.doubleToLongBits(s3) != Double.doubleToLongBits(other.s3))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Atleta [nome=" + nome + ", s=" + s + ", s1=" + s1 + ", s2=" + s2 + ", s3=" + s3 + "]";
	}

}
