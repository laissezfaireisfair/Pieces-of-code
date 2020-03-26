#pragma once
#include <string>
#include "flyBehaviour.hpp"
#include "quackBehaviour.hpp"

namespace SimUDuck {

class Duck {
protected:
FlyBehaviour *flyBehaviour;
QuackBehaviour *quackBehaviour;
std::string name;
  Duck() {}
public:
  ~Duck();
  std::string get_name() const;
  std::string fly() const;
  std::string quack() const;
  std::string swim() const;
};

}
