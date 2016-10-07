from .translator import translate


START = 1
END = 100


def main():
    translated_items = (translate(n) for n in range(START, END + 1))

    for item in translated_items:
        print(item)
