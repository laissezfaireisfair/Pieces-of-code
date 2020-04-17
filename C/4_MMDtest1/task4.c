double find_root() {
  double const accuracy = 0.0001;
  double left = 1., right = 2.;

  while (right - left > accuracy) {
    double const mid = (right + left) / 2.;
    double const midValue = cos(2./mid) - 2*sin(1./mid) + 1./mid;

    if (midValue == 0)
      return mid;
    if (midValue > 0)
      right = mid;
    else
      left = mid;
  }

  return left;
}
