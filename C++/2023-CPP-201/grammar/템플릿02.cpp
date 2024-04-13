#include <iostream>

using namespace std;

template <typename T>
class Character {
public:
	Character(string name, T attack, T defense, T health) :
		name_(name), attack_(attack), defense_(defense), health_(health) {}

	void print_situation(void)
	{
		cout << "�̸� : " << name_ << endl;
		cout << "���ݷ� : " << attack_ << endl;
		cout << "���� : " << defense_ << endl;
		cout << "ü�� : " << health_ << endl;
	}

	string get_name(void) { return name_;  }
	T get_attack(void) { return attack_; }
	T get_defense(void) { return defense_; }
	T get_health(void) { return health_; }

	void set_name(string name) { name_ = name; }
	void set_attack(T attack) { attack_ = attack; }
	void set_defense(T defense) { defense_ = defense; }
	void set_health(T health) { health_ = health; }

private:
	string name_;
	T attack_;
	T defense_;
	T health_;
};

int main() {
	Character<int>* main = new Character<int>("������", 50, 50, 50);
	main->print_situation();
	delete main;
	return 0;
}