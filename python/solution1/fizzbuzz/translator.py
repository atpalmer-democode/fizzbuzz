

def has_fizz(n):
    return n % 3 == 0


def can_buzz(n):
    return n % 5 == 0


def translate(n):
    if has_fizz(n) and can_buzz(n):
        return "FizzBuzz"
    elif has_fizz(n):
        return "Fizz"
    elif can_buzz(n):
        return "Buzz"
    else:
        return str(n)
