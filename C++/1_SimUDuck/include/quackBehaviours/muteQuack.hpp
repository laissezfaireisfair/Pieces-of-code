#pragma once
#include "../quackBehaviour.hpp"

namespace SimUDuck {

class MuteQuack : public QuackBehaviour {
public:
  std::string quack() const;
};

}
