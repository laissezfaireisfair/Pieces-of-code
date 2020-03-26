#pragma once
#include <string>

namespace SimUDuck {

class QuackBehaviour {
public:
  virtual std::string quack() const = 0;
};

}
