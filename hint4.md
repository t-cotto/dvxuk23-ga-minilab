# Hint 4

You can add args to the action to limit you results to only get severities above a certain value

```yaml
    with:
          args: --severity-threshold=high
```

Alternatively you can continue on error if you prefer that

```yaml
continue-on-error: true
```


Example:

```yaml
  opensource-security:
    needs: [ build ]
    runs-on: ubuntu-latest
    steps:
      - uses: actions/checkout@master
      - name: Run Snyk to check for vulnerabilities
        uses: snyk/actions/maven@master
        #        continue-on-error: true
        env:
          SNYK_TOKEN: ${{ secrets.SNYK_TOKEN }}
        with:
          args: --severity-threshold=high
```

