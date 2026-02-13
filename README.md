# 🐚 Bash Scripting Collection

A comprehensive collection of **20+ Bash scripts** demonstrating shell scripting fundamentals, automation patterns, and
configuration management for development environments.

![Shell Script](https://img.shields.io/badge/Shell_Script-121011?style=flat&logo=gnu-bash&logoColor=white)
![Linux](https://img.shields.io/badge/Linux-FCC624?style=flat&logo=linux&logoColor=black)
![Docker](https://img.shields.io/badge/Docker-2496ED?style=flat&logo=docker&logoColor=white)
![License](https://img.shields.io/badge/License-MIT-green)

## 📋 Overview

This repository contains a complete collection of shell scripts for:

- **Download automation** - Multi-URL download handlers
- **Loop constructs** - For, while, until, foreach implementations
- **File operations** - Read, write, and process files
- **Configuration management** - YAML, properties, and custom configs
- **Docker/Kafka/PostgreSQL** - Container orchestration scripts
- **Java/Maven** - Build and deployment automation

## 🚀 Quick Start

```bash
# Clone repository
git clone https://github.com/yourusername/bash-script-collection.git
cd bash-script-collection

# Make scripts executable
chmod +x *.sh **/*.sh

# Run any script
./script_name.sh
```

## 📁 Project Structure

```
.
├── 📂 download_links.sh         # Main download manager
│   ├── for.sh                  # For loop examples
│   ├── foreach.sh              # Array iteration
│   ├── func.sh                 # Function library
│   ├── read.sh                 # User input handling
│   ├── read_file.sh            # File reading utilities
│   ├── until.sh                # Until loop examples
│   └── while.sh                # While loop examples
│
├── 📂 config                   # Configuration files
│   ├── application.yml        # YAML configuration
│   ├── config.properties      # Properties file
│   ├── java.conf.sh          # Java configuration
│   ├── java.sh               # Java environment setup
│   ├── maven.sh              # Maven build automation
│   └── transfer.sh           # File transfer utility
│
├── 📂 crud                    # CRUD operation scripts
│   └── [bash scripts]        # Create, Read, Update, Delete
│
├── 📂 docker                  # Docker configuration
│   ├── docker-compose.yml    # Multi-container setup
│   ├── java.Dockerfile       # Java container
│   ├── ng.Dockerfile         # Angular container
│   ├── kafka.sh              # Kafka automation
│   └── postgres.sh           # PostgreSQL automation
│
├── 📂 java                    # Java-related scripts
│   └── [build scripts]       # Compilation and execution
│
└── README.md                 # You are here
```

### 2️⃣ **Loop Constructs & Control Flow**

```bash
# For loop example
for i in {1..5}; do
    echo "Iteration $i"
done

# While loop example
while read -r line; do
    process "$line"
done < input.txt

# Until loop example
until ping -c1 google.com &>/dev/null; do
    echo "Waiting for network..."
    sleep 2
done
```

### 3️⃣ **File & Input Processing**

- `read.sh` - Advanced user input handling
- `read_file.sh` - Multi-format file parsing
- `func.sh` - Reusable function library
- Conditional statements with proper validation

### 4️⃣ **Configuration Management**

```bash
# YAML parsing with application.yml
# Properties file handling
# Environment-specific configurations
# Java/Maven environment setup
```

### 5️⃣ **Container Orchestration**

```bash
# Start complete stack
docker-compose up -d

# Kafka cluster
./kafka.sh start

# PostgreSQL database
./postgres.sh init
```

### **Process Configuration**

```bash
./config/java.sh --version 17 --home /usr/lib/jvm/java-17
./config/maven.sh --clean install
```

### **Interactive Input Validation**

```bash
# Example from your script
echo "please enter yes to continue!"
read -r string
if [[ $string != "yes" && $string != "no" ]]; then
    echo "please enter yes or no!"
else
    echo "ok"
fi
```

### **Numeric Comparisons**

```bash
var1=10
var2=20
if [[ $var1 > $var2 ]]; then
    echo "$var1 > $var2"
elif [[ $var2 > $var1 ]]; then
    echo "$var2 > $var1"
else
    echo "$var2 == $var1"
fi
```

## 🛠️ ShellCheck Integration

This project recommends using **ShellCheck** for static analysis:

```bash
# Install ShellCheck
# Ubuntu/Debian
sudo apt-get install shellcheck

# macOS
brew install shellcheck

# Run analysis
shellcheck *.sh **/*.sh
```

**Note:** ShellCheck will help identify:

- Syntax errors and warnings
- Best practice violations
- Portability issues
- Performance improvements

## 📊 Script Features Matrix

| Feature                 | Implementation        | Example                       |
|-------------------------|-----------------------|-------------------------------|
| **Loops**               | for, while, until     | Array iteration, file reading |
| **Conditions**          | if-elif-else, case    | String/number comparisons     |
| **Functions**           | Modular design        | Reusable utilities            |
| **File I/O**            | Read/Write operations | Config processing             |
| **Error Handling**      | Exit codes, traps     | Graceful failures             |
| **Parallel Processing** | Background jobs       | Multi-file downloads          |

## 🚦 Best Practices Implemented

### ✅ **Good Practices**

- Shebang lines (`#!/bin/bash`)
- Quoted variables to prevent word splitting
- Input validation and sanitization
- Descriptive variable names
- Modular function design

### ⚠️ **Areas for Improvement**

```bash
# Before (demo version)
if [[ $var1 > $var2 ]]; then

# After (recommended for numeric)
if [[ $var1 -gt $var2 ]]; then

# After (recommended for lexicographic)
if [[ "$var1" > "$var2" ]]; then
```

## 🐳 Docker Integration

```bash
# Build Java application
docker build -f docker/java.Dockerfile -t java-app .

# Run Nginx server
docker build -f docker/ng.Dockerfile -t nginx-custom .

# Full stack
cd docker && docker-compose up -d
```

## 📝 Environment Setup

```bash
# Configure Java environment
source config/java.conf.sh
export JAVA_HOME=/usr/lib/jvm/java-17
export PATH=$JAVA_HOME/bin:$PATH

# Configure Maven
./config/maven.sh --settings custom-settings.xml
```

## 🤝 Contributing

1. **Add ShellCheck** to your workflow
2. Follow [Google Shell Style Guide](https://google.github.io/styleguide/shellguide.html)
3. Test scripts on multiple shells (bash, sh, zsh)
4. Document functions with comments
5. Add error handling

```bash
# Example function documentation
#######################################
# Download file with retry mechanism
# Arguments:
#   $1 - URL
#   $2 - Output path
# Returns:
#   0 on success, non-zero on failure
#######################################
```

## 📚 Learning Resources

- [Bash Hackers Wiki](https://wiki.bash-hackers.org/)
- [Advanced Bash-Scripting Guide](https://tldp.org/LDP/abs/html/)
- [ShellCheck Wiki](https://github.com/koalaman/shellcheck/wiki)
- [Google Shell Style Guide](https://google.github.io/styleguide/shellguide.html)