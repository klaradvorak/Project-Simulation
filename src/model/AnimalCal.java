package model;

public class AnimalCal {
	private String animal_type1;
	private String month;
	private String year;
	private int birth;
	private int death;
	private String weather;

	public AnimalCal(String animal_type1, String month, String year, int birth,
					 int death, String weather) {
		super();
		this.animal_type1 = animal_type1;
		this.month = month;
		this.year = year;
		this.birth = birth;
		this.death = death;
		this.weather = weather;
	}

	public String getAnimal_type1() {
		return animal_type1;
	}

	public void setAnimal_type1(String animal_type1) {
		this.animal_type1 = animal_type1;
	}

	public String getMonth() {
		return month;
	}

	public void setMonth(String month) {
		this.month = month;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	public int getBirth() {
		return birth;
	}

	public void setBirth(int birth) {
		this.birth = birth;
	}

	public int getDeath() {
		return death;
	}

	public void setDeath(int death) {
		this.death = death;
	}

	public String getWeather() {
		return weather;
	}

	public void setWeather(String weather) {
		this.weather = weather;
	}

	@Override
	public String toString() {
		return "\t" + this.getAnimal_type1() + "\t" + this.getMonth()
				+ "\t" + this.getYear() + "\t" + this.getBirth() + "\t" + this.getDeath()
				+ "\t" + this.getWeather()+ "";
	}







}
