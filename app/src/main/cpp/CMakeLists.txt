
cmake_minimum_required(VERSION 3.10.2)
project("earlyinit")

add_library(earlyinit SHARED early_init.cpp)
find_library(log-lib log)
target_link_libraries(earlyinit ${log-lib})
