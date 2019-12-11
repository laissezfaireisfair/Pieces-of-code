#include "../include/duckSpecies/redheadDuck.hpp"
#include "../include/duckSpecies/rubberDuck.hpp"
#include "../include/duckSpecies/woodenDuck.hpp"
#include <iostream>

void print_duck(const SimUDuck::Duck *duck) {
  std::cout << "Hi, i am " << duck->get_name() << "." << std::endl;
  std::cout << duck->quack() << std::endl;
  std::cout << duck->swim() << std::endl;
  std::cout << duck->fly() << std::endl;
  std::cout << "Bye!" << std::endl;
}

void simulate_ducks() {
  SimUDuck::Duck *redheadDuck = new SimUDuck::RedheadDuck;
  SimUDuck::Duck *rubberDuck = new SimUDuck::RubberDuck;
  SimUDuck::Duck *woodenDuck = new SimUDuck::WoodenDuck;
  print_duck(redheadDuck);
  std::cout << std::endl;
  print_duck(rubberDuck);
  std::cout << std::endl;
  print_duck(woodenDuck);
  std::cout << std::endl;
  delete redheadDuck;
  delete rubberDuck;
  delete woodenDuck;
}

int main () {
  simulate_ducks();
  return 0;
}
