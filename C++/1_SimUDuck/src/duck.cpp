#include "../include/duck.hpp"

std::string SimUDuck::Duck::fly() const {
  return flyBehaviour->fly();
}

std::string SimUDuck::Duck::quack() const {
  return quackBehaviour->quack();
}

std::string SimUDuck::Duck::swim() const {
  return "I am swimming";
}

std::string SimUDuck::Duck::get_name() const {
  return name;
}

SimUDuck::Duck::~Duck() {
  delete flyBehaviour;
  delete quackBehaviour;
}
