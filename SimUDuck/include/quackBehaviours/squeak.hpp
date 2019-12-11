#pragma once
#include "../quackBehaviour.hpp"

namespace SimUDuck {

class Squeak : public QuackBehaviour {
public:
  std::string quack() const;
};

}
