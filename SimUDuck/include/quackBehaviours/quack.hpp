#pragma once
#include "../quackBehaviour.hpp"

namespace SimUDuck {

class Quack : public QuackBehaviour {
public:
  virtual std::string quack() const;
};

}
