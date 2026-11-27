#pragma once

#include <string>

// Server the client connects to.
// Keep in sync with Config.SERVER_HOST / Config.SERVER_PORT (Java side).
struct ServerConfig
{
    std::string szHost = "5.57.37.215";
    int iPort = 7777;
};

inline ServerConfig GetServerConfig()
{
    ServerConfig config;
    return config;
}
