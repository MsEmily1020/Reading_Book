﻿#include <SFML/Graphics.hpp>
#include <stdlib.h>			// srand(), read()
#include <time.h>			// time()

#include <stdio.h>

#define DIR_UP		0
#define DIR_DOWN	1
#define DIR_RIGHT	2
#define DIR_LEFT	3
#define BODY_MAX	20	// 뱀의 최대 길이

using namespace sf;

const int WIDTH = 1000;
const int HEIGHT = 800;

int block = 40; // 한 칸을 40 으로
const int w = WIDTH / block;
const int h = HEIGHT / block;

class Apple {
public:
	int x_;
	int y_;
	RectangleShape sprite_;
};

class Object {
public:
	int x_;
	int y_;
	RectangleShape sprite_;
};

class Snake {
public:
	// score에 값을 주지 않으면 default로 0이 들어간다.
	Snake(int dir, int length, float thickness, float block, int score = 0) :
		dir_(dir), length_(length), thickness_(thickness), score_(score)
	{
		inner_ = block - thickness_;
	}

	void InitBody(void)
	{
		// TODO : 뱀과 사과가 걸치지 않도록 수정하기
		for (int i = 0; i < BODY_MAX; i++) {
			body_[i].x_ = -100;
			body_[i].y_ = -100;
			body_[i].sprite_.setPosition(body_[i].x_ * block, body_[i].y_ * block);
			body_[i].sprite_.setSize(Vector2f(inner_, inner_));
			body_[i].sprite_.setFillColor(Color::Green);
			// 뱀의 테두리
			body_[i].sprite_.setOutlineColor(Color::Color(0, 128, 0));
			body_[i].sprite_.setOutlineThickness(5);

		}
		body_[0].x_ = 3;
		body_[0].y_ = 3;
	}

	// 현재 사과를 먹고있는 상태인가?
	bool isCollide(Apple* apple)
	{
		return body_[0].x_ == apple->x_ && body_[0].y_ == apple->y_;
	}

	// 몸통(머리 제외)
	void UpdateBody(void)
	{
		// 몸통에 대한 이동
		for (int i = length_ - 1; i > 0; i--) {
			body_[i].x_ = body_[i - 1].x_;
			body_[i].y_ = body_[i - 1].y_;
		}
	}

	// 머리
	void UpdateHead(void)
	{
		// 머리에 대한 이동
		if (dir_ == DIR_UP) {
			body_[0].y_--;
		}

		else if (dir_ == DIR_DOWN) {
			body_[0].y_++;
		}

		else if (dir_ == DIR_LEFT) {
			body_[0].x_--;
		}

		else if (dir_ == DIR_RIGHT) {
			body_[0].x_++;
		}
	}

	void UpdateBoundary()
	{
		// 바운더리를 넘었을 때 더이상 벗어나지 않도록
		if (body_[0].x_ < 0)  body_[0].x_ = 0;
		if (body_[0].x_ >= w) body_[0].x_ = w - 1;
		if (body_[0].y_ < 0)  body_[0].y_ = 0;
		if (body_[0].y_ >= h) body_[0].y_ = h - 1;

		for (int i = 0; i < length_; i++) {
			body_[i].sprite_.setPosition(body_[i].x_ * block, body_[i].y_ * block);
		}
	}

	void Render(RenderWindow* window)
	{
		for (int i = 0; i < BODY_MAX; i++) {
			window->draw(body_[i].sprite_);
		}
	}

	int GetDir(void) { return dir_; }
	int GetLength(void) { return length_; }
	int GetScore(void) { return score_;  }
	float GetThickness(void) { return thickness_; }
	float GetInner(void) { return inner_; }

	void SetDir(int dir) { dir_ = dir; }
	void SetLength(int length) { length_ = length; }
	void SetScore(int score) { score_ = score; }
	void SetThickness(float thickness) { thickness_ = thickness; }
	void SetInner(float inner) { inner_ = inner; }

	void IncLength(void) { length_++; }
	void IncScore(int val) { score_ += val; }

private:
	int dir_;
	int length_;
	int score_;
	float thickness_;			// 외피두께
	float inner_;				// 내부두께
	Object body_[BODY_MAX];
};


int main() {
	RenderWindow  window(VideoMode(WIDTH, HEIGHT), "Snake Game");
	// 1초에 30번의 작업이 이루어 지도록 frame 조절
	// 컴퓨터 사양이 달라도 똑같이 행동 함
	window.setFramerateLimit(15);

	srand(time(NULL));

	sf::Clock clock; // SFML Clock 객체 생성
	sf::Time elapsedTime; // 경과 시간을 저장할 SFML Time 객체

	Font font;
	if (!font.loadFromFile("C:\\windows\\Fonts\\arial.ttf")) 
	{
		printf("폰트 불러오기 실패\n");
		return -1;
	}

	Text info;
	info.setFont(font);
	info.setCharacterSize(60);
	info.setFillColor(Color::Magenta);

	char info_text[100];

	Snake snake = Snake(DIR_DOWN, 1, 5.f, block);

	snake.InitBody();

	Apple apple;
	apple.x_ = rand() % w;
	apple.y_ = rand() % h;
	apple.sprite_.setPosition(apple.x_ * block, apple.y_ * block);
	apple.sprite_.setSize(Vector2f(block, block));
	apple.sprite_.setFillColor(Color::Red);

	while (window.isOpen())
	{
		Event e;
		while (window.pollEvent(e))
		{
			// 윈도우의 x를 눌렀을 때 창이 닫아지도록
			if (e.type == Event::Closed)
				window.close();
		}

		elapsedTime = clock.getElapsedTime();
		int seconds = elapsedTime.asSeconds();

		sprintf(info_text, "score : %d time : %d\n", snake.GetScore(), seconds);
		info.setString(info_text);

		if (Keyboard::isKeyPressed(Keyboard::Up))
		{
			snake.SetDir(DIR_UP);
		}

		else if (Keyboard::isKeyPressed(Keyboard::Down))
		{
			snake.SetDir(DIR_DOWN);
		}

		else if (Keyboard::isKeyPressed(Keyboard::Left))
		{
			snake.SetDir(DIR_LEFT);
		}

		else if (Keyboard::isKeyPressed(Keyboard::Right))
		{
			snake.SetDir(DIR_RIGHT);
		}
		
		// update
		// 뱀이 사과를 먹었을 때 몸통 길어짐
		if (snake.isCollide(&apple))
		{
			apple.x_ = rand() % w;
			apple.y_ = rand() % h;
			apple.sprite_.setPosition(apple.x_ * block, apple.y_ * block);
			snake.IncScore(100);
			if (snake.GetLength() < BODY_MAX)
				snake.IncLength();
		}

		snake.UpdateBody();
		snake.UpdateHead();
		snake.UpdateBoundary();

		// render
		window.clear();

		snake.Render(&window);
		
		window.draw(apple.sprite_);	// 뱀과 사과가 겹칠경우 사과가 위에 나옴
		window.draw(info);

		window.display();
	}
	return 0;
}