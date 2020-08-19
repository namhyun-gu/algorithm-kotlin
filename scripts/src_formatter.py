import sys

if len(sys.argv) == 0:
    print("Required source arguments")
    exit()

source = sys.argv[1]
source = "src/main/java/" + source


def has_package(line: str) -> bool:
    return line.startswith("package")


def replace_classname(line: str) -> str:
    class_declation = "public class "
    if line.startswith(class_declation):
        classname = line[len(class_declation):len(line) - 3]
        return line.replace(classname, "Main")
    else:
        return line


def is_comment(line: str) -> bool:
    return line.startswith("//") or line.startswith("/**") or line.startswith("**/")


with open(source) as file:
    for line in file.readlines():
        if has_package(line):
            continue
        if is_comment(line):
            continue
        line = replace_classname(line)
        line = line.replace('\n', '')
        print(line)
