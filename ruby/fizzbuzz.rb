TRANSFORMATIONS = {
  3 => 'Fizz',
  5 => 'Buzz',
}

class Integer
  def fizzbuzz
    TRANSFORMATIONS.inject(nil) do |result, (k, v)|
      (result || "") + v if self % k == 0
    end || self
  end
end

1.upto(100).map(&:fizzbuzz).each { |value| puts value }
